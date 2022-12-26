package com.thanhthien.cuoiki.services.impl;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.converts.PostConvert;
import com.thanhthien.cuoiki.converts.UserConvert;
import com.thanhthien.cuoiki.dto.PostEditDto;
import com.thanhthien.cuoiki.dto.PostMaintDto;
import com.thanhthien.cuoiki.dto.PostShowDto;
import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.form.CategoryCreateForm;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.form.PostEditForm;
import com.thanhthien.cuoiki.model.CategoryEntity;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.model.UserEntity;
import com.thanhthien.cuoiki.model.EnumType.StatusPost;
import com.thanhthien.cuoiki.repository.CategoryRepository;
import com.thanhthien.cuoiki.repository.PostRepository;
import com.thanhthien.cuoiki.services.IPostService;

@Service
public class PostService implements IPostService {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	@Autowired
	PostRepository postRepository;

	@Autowired
	CategoryService categoryService;

	@Autowired
	StorageService storageService;

	@Autowired
	PostConvert postConvert;

	@Autowired
	UserService userService;

	@Override
	public PostEntity createPost(PostCreateForm postCreateForm) {
		Boolean existSlug = existPost(convertSlug(postCreateForm.getTitle()));

		if (existSlug) {
			return null;
		}

		PostEntity postEnti = postConvert.toEntity(postCreateForm);

		postEnti.setSlug(convertSlug(postCreateForm.getTitle()));

		UserEntity author = userService.findOneById(postCreateForm.getAuthorId());

		if (author == null) {
			return null;
		}

		postEnti.setAuthor(author);

		String[] listCategory = postCreateForm.getCategories().split(",");
		List<CategoryEntity> categories = new ArrayList<>();

		for (String category : listCategory) {
			Boolean check = categoryService.checkExistCategoryBySlug(categoryService.convertSlug(category));

			if (check) {
				CategoryEntity ca1 = categoryService.findCategoryBySlug(categoryService.convertSlug(category));

				categories.add(ca1);
			} else {
				CategoryCreateForm formCatgory = new CategoryCreateForm();

				formCatgory.setStatus(true);
				formCatgory.setTitle(category);

				CategoryEntity categoryEntity = categoryService.createCategory(formCatgory);

				categories.add(categoryEntity);
			}
		}

		postEnti.setCategories(categories);

		String avatar = storageService.storageFile(postCreateForm.getAvatar());

		if (avatar == null) {
			return null;
		}

		postEnti.setAvatar(avatar);

		postEnti = postRepository.save(postEnti);

		if (postEnti != null) {
			return postEnti;
		}

		return null;
	}

	@Override
	public Boolean existPost(String slug) {
		return postRepository.existsBySlug(slug);
	}

	@Override
	public String convertSlug(String title) {
		String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	@Override
	public List<PostShowDto> getPostsWithStatus(String status) {

		StatusPost statusPost = StatusPost.PUBLIC;
		List<PostEntity> posts;

		if (status == "PUBLIC") {
			posts = postRepository.findAllByStatus(StatusPost.PUBLIC);
		} else if (status == "UNPUBLIC") {
			posts = postRepository.findAllByStatus(StatusPost.UNPUBLIC);
		} else if (status == "DRAFT") {
			posts = postRepository.findAllByStatus(StatusPost.DRAFT);
		} else {
			posts = postRepository.findAllByOrderByCreateAtDesc();
		}

		List<PostShowDto> postShows = postConvert.toListDtoShow(posts);

		if (postShows == null) {
			return null;
		}

		return postShows;
	}

	@Override
	public PostEditDto getPostById(Long id) {
		PostEntity postOld = postRepository.findOneById(id);

		if (postOld == null) {
			return null;
		}

		PostEditDto dtoPost = postConvert.toDtoEdit(postOld);

		return dtoPost;
	}

	@Override
	public PostEntity updatePost(PostEditForm postEditForm) {

		PostEntity oldPost = postRepository.findOneById(postEditForm.getIdPost());

		if (oldPost == null) {
			return null;
		}

		oldPost.setTitle(postEditForm.getTitle());
		oldPost.setSummary(postEditForm.getSummary());
		oldPost.setContent(postEditForm.getContent());

		StatusPost status;
		if (postEditForm.getStatus().equals("DRAFT")) {
			status = StatusPost.DRAFT;
		} else if (postEditForm.getStatus().equals("PUBLIC")) {
			status = StatusPost.PUBLIC;
		} else {
			status = StatusPost.UNPUBLIC;
		}
		oldPost.setStatus(status);

		String[] listCategory = postEditForm.getCategories().split(",");
		List<CategoryEntity> categories = new ArrayList<>();

		for (String category : listCategory) {
			Boolean check = categoryService.checkExistCategoryBySlug(categoryService.convertSlug(category));

			if (check) {
				CategoryEntity ca1 = categoryService.findCategoryBySlug(categoryService.convertSlug(category));

				categories.add(ca1);
			} else {
				CategoryCreateForm formCatgory = new CategoryCreateForm();

				formCatgory.setStatus(true);
				formCatgory.setTitle(category);

				CategoryEntity categoryEntity = categoryService.createCategory(formCatgory);

				categories.add(categoryEntity);
			}
		}

		oldPost.setCategories(categories);

		if (postEditForm.getAvatar() != null) {
			String avatar = storageService.storageFile(postEditForm.getAvatar());

			if (avatar == null) {
				return null;
			}

			oldPost.setAvatar(avatar);
		}

		PostEntity newPost = postRepository.save(oldPost);

		if (newPost == null) {
			return null;
		}

		return newPost;
	}

	@Override
	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public List<PostShowHomeDto> getAllPostNew() {
		List<PostEntity> posts = postRepository.findAllByOrderByCreateAtDesc();

		if (posts == null) {
			return null;
		}

		List<PostShowHomeDto> dtos = postConvert.toListDtoShowHome(posts);

		return dtos;
	}

	@Override
	public List<PostShowHomeDto> getPostsCount(int limit) {
		List<PostEntity> postEntity = postRepository.getPostOrderCountWithLimit(limit);

		if (postEntity == null) {
			return null;
		}

		List<PostShowHomeDto> dtos = postConvert.toListDtoShowHome(postEntity);

		return dtos;
	}

}

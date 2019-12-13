package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Post;

public class AuthorServicesImpl implements AuthorServices {

    private PostDao postDao;

    public AuthorServicesImpl () {
        this.postDao=new PostDao();
    }

    @Override
    public void submitComment() {

    }

    @Override
    public void deleteMyPost() {
    }

    @Override
    public void updateMyPost(Post post, Post newPost) {
        Post postToUpdate = postDao.getPost(post.getIdPost());
        postToUpdate.setTitle(newPost.getTitle());
        postToUpdate.setText(newPost.getText());
        postDao.updatePost(postToUpdate);
    }

    @Override
    public void deleteAComment() {

    }

    @Override
    public void submitBlogPost() {

    }

    @Override
    public void updateAvatar() {

    }

    @Override
    public void deleteProfile() {

    }

    @Override
    public void logOut() {

    }

    @Override
    public void updateUserinformation() {

    }

    @Override
    public void updatePassword() {

    }
}

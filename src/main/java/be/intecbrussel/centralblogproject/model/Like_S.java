package be.intecbrussel.centralblogproject.model;


import javax.persistence.*;

@Entity
public class Like_S {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likeId;


    @ManyToOne
    private Post post;


    @ManyToOne
    private User user;


    public void cloneFrom(Like_S likeS) {
        this.likeId = likeS.likeId;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Like_S{" +
                "likeId=" + likeId +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}

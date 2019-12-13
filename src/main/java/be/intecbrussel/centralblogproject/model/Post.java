package be.intecbrussel.centralblogproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    private String title;
    @Lob
    private String text;
    private LocalDateTime dateTime;
    @Column(name = "popularity")
    private int likeCounter;
    @ManyToMany(mappedBy = "posts")
    private Set<Tag> tags;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public void cloneFrom(Post post) {
        this.idPost = post.idPost;
        this.title = post.title;
        this.text = post.text;
        this.user = post.user;
        this.dateTime = post.dateTime;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime localDate) {
        this.dateTime = localDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", localDate=" + dateTime +
                ", user=" + user +
                '}';
    }
}

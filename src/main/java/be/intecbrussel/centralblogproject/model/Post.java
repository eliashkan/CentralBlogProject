package be.intecbrussel.centralblogproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    private String title;
    private String text;
<<<<<<<Updated upstream
    private LocalDate localDate;

=======
    Stashed changes
    @ManyToOne
    private User user;
    Stashed changes
    private LocalDateTime dateTime;
>>>>>>>
    @Column(name = "popularity")
    private Integer likeCounter;

    @OneToMany
    @JoinColumn(name = "post")
    private List<Comment> comments = new ArrayList<>();
    @ManyToMany(mappedBy = "posts")
    private Set<Tag> tags;

    public void cloneFrom(Post post) {
        this.idPost = post.idPost;
        this.title = post.title;
        this.text = post.text;
        this.user = post.user;
        this.localDate = post.localDate;
        this.comments = post.comments;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

<<<<<<<Updated upstream
=======

    public void setLikeCounter(Integer likeCounter) {
        this.likeCounter = likeCounter;
    }

    public Set<Tag> getTags() {
        return tags;
    }

>>>>>>>

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
                ", localDate=" + localDate +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
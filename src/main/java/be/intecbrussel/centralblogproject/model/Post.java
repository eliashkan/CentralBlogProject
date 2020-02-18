package be.intecbrussel.centralblogproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
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


    @ManyToMany(mappedBy = "posts")
    private Set<Tag> tags;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post")
    private List<Comment> comments = new ArrayList<>();

    public void cloneFrom(Post post) {
        this.idPost = post.idPost;
        this.title = post.title;
        this.text = post.text;
        this.user = post.user;
        this.dateTime = post.dateTime;
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

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    public String formatDateTime() {

        String formatedDateTime = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

        return formatedDateTime;
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
                ", dateTime=" + dateTime +
//                ", likeCounter=" + likeCounter +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}



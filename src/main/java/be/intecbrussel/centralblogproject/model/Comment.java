package be.intecbrussel.centralblogproject.model;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;
    private String text;

    @ManyToOne
    private User user;


    @ManyToOne
    private Post post;

    public void cloneFrom(Comment comment) {
        this.idComment = comment.getIdComment();
        this.text = comment.getText();
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}

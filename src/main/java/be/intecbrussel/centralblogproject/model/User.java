package be.intecbrussel.centralblogproject.model;


import be.intecbrussel.centralblogproject.model.Utilities.ImageRecovery;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    private String fullName;
    private String address;
    @Length(min = 4)
    @NotNull
    private String userName;
    @Length(min = 8, max = 20, message = "A password must contain between 8 and 20 characters and a special character, digit and low and upper case letters.")
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
    private String password;
    @NotNull
    @Email
    private String email;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    //BLOB has a size of 65535 bytes
    //MEDIUMBLOB has a size of 16777215 bytes
    private byte[] avatar;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;


    public void cloneFrom(User user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.fullName = user.fullName;
        this.password = user.password;
        this.address = user.address;
        this.email = user.email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(String url) throws Exception {
        this.avatar = ImageRecovery.recoverImageFromUrl(url);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}




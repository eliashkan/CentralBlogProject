package be.intecbrussel.centralblogproject.main;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactoryProvider.getEM();


        VisitorServicesImpl vo = new VisitorServicesImpl();


        for (Post post : vo.getPostsByAuthor("wvan0")) {
            System.out.println(post.getTitle());
        }
    }
}
















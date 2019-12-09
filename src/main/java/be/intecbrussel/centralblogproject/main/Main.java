package be.intecbrussel.centralblogproject.main;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.dao.TagRepositoryImpl;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;
import be.intecbrussel.centralblogproject.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //Initialise
        EntityManagerFactoryProvider
                .getEM();

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();
        TagRepositoryImpl tri = new TagRepositoryImpl();


        //Testing 2 users
        User user1 = new User();
        User user2 = new User();
        user1.setUserName("Morihalla");
        user1.setFullName("Ketels dieter");
        //user1.setEmail("ketelsdieter@hotmail.be");
        user1.setPassword("BLack2TheBone");
        user1.setAdress("Rue de midi 666");
        user2.setUserName("Melalinde");
        user2.setFullName("Folkie Midgard");
        //user2.setEmail("gameplayer@live.be");
        user2.setPassword("Metal4Ever");
        user2.setAdress("Beernegemstraat 13");


        //One Post.
        Post post = new Post();
        post.setUser(user1);
        post.setText("Are you talking to me ???");


        //Making Comments.
        Comment comment = new Comment();
        comment.setUser(user2);
        comment.setText("Taxi Driver.Love it");
        Comment comment2 = new Comment();
        comment2.setUser(user2);
        comment2.setText("Very good movie");


        //Sending data.
        user1 = userDao.createUser(user1);
        user2 = userDao.createUser(user2);


        //Put the comments to the post.

        //de comments worden via de DAO.createComment in de lijst bijgevoegd,zodanig dat we de effectieve rowq terug krijgen.
        post.getComments().add(commentDao.createComment(comment));
        post.getComments().add(commentDao.createComment(comment2));


        post = postDao.createPost(post);


        //testing delete post
        //postDao.deletePost(post);



        //testing delete coms
       commentDao.deleteComment(post.getComments().get(0));

        //create tags
        Tag tagOne = new Tag();
        tagOne.setName("secretive");
        Tag tagTwo = new Tag();
        tagTwo.setName("fairy");


        //creating a post
        Post postOne = new Post();
        postOne.setTitle("Let me tell you a secret");
        postOne.setText("A jealous stepmother persuades her husband, the king, to lock his daughter in a castle in the forest. One day, a king's son goes by, hunting, and is astounded to see the abandoned castle in use. He sees the daughter, but they are unable to communicate except by gesture. A witch, to help them, tricks the ladies-in-waiting into giving the princess a book. When she ruffles the pages forward, her lover turns into a canary; when she ruffles them back, he is restored to his human form.\n" +
                "\n" +
                "After some time, the queen arrives and sees a young man by the window, and puts pins on the window sill so that if the daughter leaned on it to flirt, she would be stabbed. These pins stab the prince in his canary form, and even when the princess restores him, the prince lies on the ground, bleeding, and his companions must bear him back to his father. The princess escapes by cutting up her sheets for a rope, and overhears witches talking of things; one describes how to heal the prince. She does so, and asks for his coat-of-arms, his standard, and his vest as her reward.\n" +
                "\n" +
                "He goes hunting, and she turns him into a canary. When he flies to her room and she turns him back, he reproaches her for his injury. She produces her reward to prove that she saved him, and tells him that it was her stepmother's doing. They marry, and the daughter reveals to her father how wicked her imprisonment had been. ");
        postOne.setUser(user1);
        //creating a second post
        Post postTwo = new Post();
        postTwo.setTitle("Salted caramel cheesecake recipe");
        postTwo.setText("Heat oven to 180C/160C fan/ gas 6. Butter a 23cm springform cake tin and line the base with baking parchment. Tip the biscuits into a food processor, blitz to crumbs and pour in the melted butter. (You could also tip the biscuits into a bag, bash with a rolling pin into crumbs and mix in the butter.) Press the biscuit mixture into the base of the tin – the easiest way to do this is by flattening it with your hand under a sheet of cling film. Place the tin on a tray and bake for 10 mins, then remove from the oven to cool.\n" +
                "\n" +
                "    Meanwhile, scrape the cream cheese into a bowl with 3 tbsp of the caramel sauce, the vanilla, sugar and flour, and beat until smooth. Beat in the eggs, one at a time, until you have a thick, smooth custard consistency. Tip over the base, scraping the bowl clean, and bake in the oven for 10 mins. Reduce the temperature to 140C/120C fan/gas 1 and continue to bake for 25-30 mins until there is a slight wobble in the centre. Turn off the heat and leave the door just slightly ajar – a tea towel holding the door open is ideal. This should leave you with a completely smooth top, but if there are a couple of small cracks, don’t worry. Leave the cheesecake in the oven until completely cool (overnight is fine), then chill until needed. Will keep in the fridge for two days.\n" +
                "\n" +
                "    On the day, loosen the sides of the cheesecake from the tin with a knife and remove the base (although I usually serve it straight from the tin base). Add a large pinch of flaky sea salt to the rest of the caramel sauce, then spoon it over the cake and swirl with the back of the spoon. The cheesecake will sit happily on a stand at room temperature for a couple of hours. Just before serving, sprinkle with extra sea salt, if you like.");
        postTwo.setUser(user2);

        //connecting tags with posts
        Set<Post> setOfPostsOne = new HashSet<>();
        setOfPostsOne.add(postOne);
        setOfPostsOne.add(postTwo);
        Set<Post> setOfPostsTwo = new HashSet<>();
        setOfPostsTwo.add(postOne);
        tagOne.setPosts(setOfPostsOne);
        tagTwo.setPosts(setOfPostsTwo);
        //connecting posts with tags
        Set<Tag> setOfTagsOne = new HashSet<>();
        setOfTagsOne.add(tagOne);
        setOfTagsOne.add(tagTwo);
        Set<Tag> setOfTagsTwo = new HashSet<>();
        setOfTagsTwo.add(tagOne);
        postOne.setTags(setOfTagsOne);
        postTwo.setTags(setOfTagsTwo);

        //persisting both posts and tags
        postDao.createPost(postOne);
        postDao.createPost(postTwo);
        tri.saveTag(tagOne);
        tri.saveTag(tagTwo);

        //testing searchPost
        Stream<Post> result = postDao.searchPost(tagOne);
        result.forEach(p -> System.out.println(p.getTitle()));
        //WORKS




    }


}

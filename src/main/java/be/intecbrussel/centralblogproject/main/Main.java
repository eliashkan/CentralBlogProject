package be.intecbrussel.centralblogproject.main;

import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.dao.TagRepositoryImpl;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;
import be.intecbrussel.centralblogproject.model.User;
import be.intecbrussel.centralblogproject.service.AuthorServicesImpl;
import be.intecbrussel.centralblogproject.service.VisitorServices;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();
        TagRepositoryImpl tri = new TagRepositoryImpl();

        AuthorServicesImpl aSI = new AuthorServicesImpl();


        //creating users
        User userOne = new User();
        userOne.setUserName("hacker");
        userOne.setFullName("David McKintosh");
        userOne.setPassword("y0lom@tE");
        userOne.setAddress("Herald Drive 48, Birmingham");
        userOne.setEmail("hellostruck@gmail.com");
        userOne.setAvatar("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/dafaf4ba-a214-4d0c-bfe6-84149e815b4a/d3gkvyj-6071be62-d027-4a18-9e6a-a25a8e63228e.jpg/v1/fill/w_900,h_720,q_75,strp/hacker__s_pirate_flag_by_300nukez-d3gkvyj.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwic3ViIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl0sIm9iaiI6W1t7InBhdGgiOiIvZi9kYWZhZjRiYS1hMjE0LTRkMGMtYmZlNi04NDE0OWU4MTViNGEvZDNna3Z5ai02MDcxYmU2Mi1kMDI3LTRhMTgtOWU2YS1hMjVhOGU2MzIyOGUuanBnIiwid2lkdGgiOiI8PTkwMCIsImhlaWdodCI6Ijw9NzIwIn1dXX0.9Vy71WWK43kCwu5fXI7-YOZes0XsfKUNI3HMo6mAxyA");

        User userTwo = new User();
        userTwo.setUserName("PinkPony");
        userTwo.setFullName("Charles Stevens");
        userTwo.setPassword("n0V@rneveR");
        userTwo.setAddress("Rose Crescent 1, South Creek");
        userTwo.setEmail("conquerAndDivide@gmail.com");
        userTwo.setAvatar("https://tse3.mm.bing.net/th?id=OIP.99PxUepvbKCQ82vaUL0a8gHaEK&pid=Api");

        User userThree = new User();
        userThree.setUserName("TheDiviner");
        userThree.setFullName("Justice Minankwo");
        userThree.setPassword("Dubra!d0n");
        userThree.setAddress("Rose Crescent 19, South Avenue");
        userThree.setEmail("nowornever@gmail.com");
        userThree.setAvatar("https://tse3.mm.bing.net/th?id=OIP.MJXyD3K0TTNQht5zwlZ9-QHaE8&pid=Api");

        //persisting users
        userDao.createUser(userOne);
        userDao.createUser(userTwo);
        userDao.createUser(userThree);

        //create tags
        Tag tagOne = new Tag();
        tagOne.setName("secretive");
        Tag tagTwo = new Tag();
        tagTwo.setName("useful");
        Tag tagThree = new Tag();
        tagThree.setName("David");


        //creating a post
        Post postOne = new Post();
        postOne.setTitle("Let me tell you a secret");
        postOne.setText("A jealous stepmother persuades her husband, the king, to lock his daughter in a castle in the forest. One day, a king's son goes by, hunting, and is astounded to see the abandoned castle in use. He sees the daughter, but they are unable to communicate except by gesture. A witch, to help them, tricks the ladies-in-waiting into giving the princess a book. When she ruffles the pages forward, her lover turns into a canary; when she ruffles them back, he is restored to his human form.\n" +
                "\n" +
                "After some time, the queen arrives and sees a young man by the window, and puts pins on the window sill so that if the daughter leaned on it to flirt, she would be stabbed. These pins stab the prince in his canary form, and even when the princess restores him, the prince lies on the ground, bleeding, and his companions must bear him back to his father. The princess escapes by cutting up her sheets for a rope, and overhears witches talking of things; one describes how to heal the prince. She does so, and asks for his coat-of-arms, his standard, and his vest as her reward.\n" +
                "\n" +
                "He goes hunting, and she turns him into a canary. When he flies to her room and she turns him back, he reproaches her for his injury. She produces her reward to prove that she saved him, and tells him that it was her stepmother's doing. They marry, and the daughter reveals to her father how wicked her imprisonment had been. ");
        postOne.setUser(userOne);
        postOne.setLikeCounter(3);
        postOne.setDateTime(LocalDateTime.of(2017, 9, 11, 7, 32, 54));
        //creating a second post
        Post postTwo = new Post();
        postTwo.setTitle("David's favorite festive cheesecake");
        postTwo.setText("Heat oven to 180C/160C fan/ gas 6. Butter a 23cm springform cake tin and line the base with baking parchment. Tip the biscuits into a food processor, blitz to crumbs and pour in the melted butter. (You could also tip the biscuits into a bag, bash with a rolling pin into crumbs and mix in the butter.) Press the biscuit mixture into the base of the tin – the easiest way to do this is by flattening it with your hand under a sheet of cling film. Place the tin on a tray and bake for 10 mins, then remove from the oven to cool.\n" +
                "\n" +
                "    Meanwhile, scrape the cream cheese into a bowl with 3 tbsp of the caramel sauce, the vanilla, sugar and flour, and beat until smooth. Beat in the eggs, one at a time, until you have a thick, smooth custard consistency. Tip over the base, scraping the bowl clean, and bake in the oven for 10 mins. Reduce the temperature to 140C/120C fan/gas 1 and continue to bake for 25-30 mins until there is a slight wobble in the centre. Turn off the heat and leave the door just slightly ajar – a tea towel holding the door open is ideal. This should leave you with a completely smooth top, but if there are a couple of small cracks, don’t worry. Leave the cheesecake in the oven until completely cool (overnight is fine), then chill until needed. Will keep in the fridge for two days.\n" +
                "\n" +
                "    On the day, loosen the sides of the cheesecake from the tin with a knife and remove the base (although I usually serve it straight from the tin base). Add a large pinch of flaky sea salt to the rest of the caramel sauce, then spoon it over the cake and swirl with the back of the spoon. The cheesecake will sit happily on a stand at room temperature for a couple of hours. Just before serving, sprinkle with extra sea salt, if you like.");
        postTwo.setUser(userTwo);
        postTwo.setLikeCounter(2);
        postTwo.setDateTime(LocalDateTime.of(2019, 1, 31, 4, 52));
        //creating a third post
        Post postThree = new Post();
        postThree.setTitle("How to Build a DIY Solar Panel");
        postThree.setText("Solar Panel Power Output\n" +
                "\n" +
                "The second consideration is the power output you require. To calculate how many solar cells you need, divide the total power you need by the power of each cell. For example, if you need a 200W panel and you are using 4W cells then you need 200W / 4W = 50 cells. It is important to note that the power output is not related to whether the cells are connected in series or parallel. You can read this article on sizing your solar panel system correctly for your home for help estimating your home’s power consumption. There is also a spreadsheet available to assist you with the household power consumption calculations.\n" +
                "Solar Panel Frame\n" +
                "\n" +
                "Lastly you need a frame for your solar cells. Solar cells are extremely fragile and need to be protected, usually with a perspex sheet or glass. Additionally you need to protect the back of the cells although this sheet does not have to be clear and can be made from wood, plywood, glass or plastic. You will also need to make a frame which attached to the backing for mounting the panel.\n" +
                "How To Assemble The Panel\n" +
                "\n" +
                "In this guide, we will make a small 36W panel although the methodology to create a larger 200W or 300W panel is the same.\n" +
                "What You Will Need For One Panel\n" +
                "\n" +
                "    9 Solar Cells (0.5V 4W) – Buy Here\n" +
                "    2 Sheets of 3mm Safety/Shatterproof Glass 0.5m x 0.6m (20″ x 24″) – Buy Here\n" +
                "    Silicon Sealant – Buy Here\n" +
                "    Solar Bus Wire – Buy Here\n" +
                "    Solar Tabbing Wire – Buy Here\n" +
                "    Flux Pen / Solar Pen – Buy Here\n" +
                "    Soldering Iron – Buy Here – Buy Here\n" +
                "\n" +
                "How To Build Your Panel\n" +
                "\n" +
                "First you need to start by planning your panel layout. This is usually done according to the space you have available for the panel, you may be restricted by length or width of the panel and you can adjust the other dimensions to suite. For the 9 solar cells, a sheet of glass 0.5m x 6m (20″ x 24″) was used and the cells were laid out as shown below:");
        postThree.setUser(userThree);
        postThree.setLikeCounter(8);
        postThree.setDateTime(LocalDateTime.of(2019, 1, 11, 17, 55, 14));
        //creating a fourth post
        Post postFour = new Post();
        postFour.setTitle("How To Build a Solar Oven");
        postFour.setText("\n" +
                "\n" +
                "Use the sun's energy to heat up a tasty treat with this simple solar oven! Have you ever heard the expression that it's so hot out you could fry an egg on the sidewalk? Have you ever wondered if it's true? Find out with this easy, fun, and delicious solar oven science project that uses only household items and a pizza box. Plus, learn about absorption, insulation, and the sun's energy.\n" +
                "\n" +
                "Want even more solar energy science? Check out these solar energy science projects. And for another edible science project that teaches about insulation, make Baked Alaska.\n" +
                "Use a box knife or sharp scissors to cut a flap in the lid of the pizza box. Cut along three sides, leaving about an inch between the sides of the flap and the edges of the lid. Fold this flap out so that it stands up when the box lid is closed.  Cover the inner side of the flap with aluminum foil so that it will reflect rays from the sun. To do this, tightly wrap foil around the flap, then tape it to the back, or outer side of the flap.Use clear plastic wrap to create an airtight window for sunlight to enter into the box. Do this by opening the box and taping a double layer of plastic wrap over the opening you made when you cut the flap in the lid. Leave about an inch of plastic overlap around the sides and tape each side down securely, sealing out air. If you use a plastic bag, cut out a square big enough to cover the opening, and tape one layer over the opening.");
        postFour.setUser(userThree);
        postFour.setLikeCounter(71);
        postFour.setDateTime(LocalDateTime.of(2016, 5, 24, 9, 11, 01));
        //adding the posts to the users
        userOne.setPosts(new ArrayList<>());
        userOne.getPosts().add(postOne);
        userTwo.setPosts(new ArrayList<>());
        userTwo.getPosts().add(postTwo);
        userThree.getPosts().add(postThree);
        userThree.getPosts().add(postFour);


        /*
        Post postFive = new Post();
        postFive.setTitle("post five");
        postDao.createPost(postFive);
        Post postSix = new Post();
        postSix.setTitle("post six");
        postDao.createPost(postSix);
        Post postSeven = new Post();
        postSeven.setTitle("post seven");
        postDao.createPost(postSeven);
        */

        //connecting tags with posts
        Set<Post> setOfPostsOne = new HashSet<>();
        setOfPostsOne.add(postOne);
        setOfPostsOne.add(postTwo);
        Set<Post> setOfPostsTwo = new HashSet<>();
        setOfPostsTwo.add(postOne);
        tagOne.setPosts(setOfPostsOne);
        tagTwo.setPosts(setOfPostsTwo);
        Set<Post> setOfPostsThree = new HashSet<>();
        //connecting posts with tags
        Set<Tag> setOfTagsOne = new HashSet<>();
        setOfTagsOne.add(tagOne);
        setOfTagsOne.add(tagTwo);
        Set<Tag> setOfTagsTwo = new HashSet<>();
        setOfTagsTwo.add(tagOne);
        postOne.setTags(setOfTagsOne);
        postTwo.setTags(setOfTagsTwo);

        //persisting both posts and tags
        //postDao.createPost(postOne);
        //postDao.createPost(postTwo);
        aSI.submitBlogPost(postOne);
        aSI.submitBlogPost(postTwo);
        aSI.submitBlogPost(postThree);
        aSI.submitBlogPost(postFour);
        tri.saveTag(tagOne);
        tri.saveTag(tagTwo);

        //create a comment on post two
        Comment commentOne = new Comment();
        commentOne.setText("I will definitely make this cake this Christmas. Delicious!");
        commentOne.setUser(userOne);
        commentOne.setPost(postTwo);
        //adding comment to user
        userOne.setComments(new ArrayList<>());
        userOne.getComments().add(commentOne);
        //persisting this comment
        aSI.submitComment(commentOne);

        //assigning the comment to the post's list
        postTwo.setComments(new ArrayList<>());
        postTwo.getComments().add(commentOne);



        //testing searchPost
        //List<Post> result = postDao.searchPost(tagOne);
        //result.forEach(p -> System.out.println(p.getTitle()));

        //testing sortPostsByDateDesc
        //List<Post> result = postDao.sortPostsByDateAsc();
        //result.forEach(p -> System.out.println(p.getTitle() + "\t" + p.getDateTime()));

        //testing sortPostsByPopularity
        //List<Post> result = postDao.sortPostsByPopularityDesc();
        //result.forEach(p -> System.out.println(p.getTitle() + "\t" + p.getLikeCounter()));

        //testing paging
        /*
        List<Post> result = postDao.showSixPostsWithPaging(3);
        result.forEach(p -> System.out.println(p.getIdPost() + "\t" + p.getTitle()));
        */

        /*
        testing updateAddress()
        userOne.setAddress("14 Hollyroad St, Dunbar");
        aSI.updateUserInformation(userOne, userOne);
        */

        /*
        //testing updateAvatar
        //you might need to change the size of your MySQL server package size here C:\xampp\mysql\bin\my.conf
        //see: https://dev.mysql.com/doc/refman/5.5/en/packet-too-large.html
        aSI.updateAvatar(userOne, "https://tau0.files.wordpress.com/2013/04/long_desert_road_2.jpg");
        */

        VisitorServices vSI = new VisitorServicesImpl();

        /*
        sorting posts by popularity
        vSI.sortPostsByPopularity().
                map(p -> p.getTitle() + "\t" + p.getLikeCounter()).
                forEach(System.out::println);
        */

        //get posts by author
        /*
        vSI.getPostsByAuthor("steve")
                .forEach(p-> System.out.println(p.getTitle()));

         */
        /*
        vSI.getSixPosts(vSI.getPosts())
                .forEach(p -> System.out.println(p.getTitle() + "\t" + p.getDateTime()));
                */
        //System.out.println(vSI.getSpecificPost(1).getText());





    }
}

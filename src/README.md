For the Phase 1 of our project, the CRUD folder contains all of our creation and reading of our users, comments, and posts. Every single .java file inside of CRUD contains a constructor and get methods for each object. 

To manage all of our users, posts, and comments, we are using an interface named manager that contains a list of all the objects that we use. Individually, postManager and userManager would singlehandedly control all the deletion and editing of the posts and users from that list.

For our testing, we are adding preset cases within test.java alongside allowing the user to login, create, read, update, and delete posts.

In Phase 2 of our project, updates were made to our .java files to implement karma functionality in our users, posts, and comments classes as well as functionality for sorting in the classes aforementioned. Methods for upvote/downvote can be found in the UserManager class.

Our test.java file was updated accordingly and testing was implemented for Phase 2.

package com.mini.miniproject.dbSet;

import com.mini.miniproject.model.CommentDto;
import com.mini.miniproject.model.Post;
import com.mini.miniproject.model.PostDto;
import com.mini.miniproject.model.UserDto;
import com.mini.miniproject.service.CommentService;
import com.mini.miniproject.service.PostService;
import com.mini.miniproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SetTestDb {
    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    public void dbset(){
        userSet();
        postSet();
        commentSet();
    }


    public void userSet()
    {
        UserDto user1 = new UserDto();
        user1.setUserNick("dltmdwns");
        user1.setId("tmdwns123");
        user1.setPassword("1234");
        user1.setPasswordconfirm("1234");
        userService.registerUser(user1);
        UserDto user2 = new UserDto();
        user2.setUserNick("wjddudgh");
        user2.setId("dudgh123");
        user2.setPassword("1234");
        user2.setPasswordconfirm("1234");
        userService.registerUser(user2);
    }

    public void postSet()
    {
        PostDto reqdto = new PostDto();
        reqdto.setCategori(0L);
        reqdto.setContent("내용");
        reqdto.setTitle("제목1");
        postService.createPosts(reqdto,"tmdwns123");
        PostDto reqdto2 = new PostDto();
        reqdto2.setCategori(1L);
        reqdto2.setContent("내용2");
        reqdto2.setTitle("제목2");
        postService.createPosts(reqdto2,"tmdwns123");
        PostDto reqdto3 = new PostDto();
        reqdto3.setCategori(2L);
        reqdto3.setContent("내용3");
        reqdto3.setTitle("제목3");
        postService.createPosts(reqdto3,"tmdwns123");
        PostDto reqdto4 = new PostDto();
        reqdto4.setCategori(0L);
        reqdto4.setContent("내용4");
        reqdto4.setTitle("제목4");
        postService.createPosts(reqdto4,"tmdwns123");
        PostDto reqdto5 = new PostDto();
        reqdto5.setCategori(1L);
        reqdto5.setContent("내용5");
        reqdto5.setTitle("제목5");
        postService.createPosts(reqdto5,"tmdwns123");
        PostDto reqdto7 = new PostDto();
        reqdto7.setCategori(2L);
        reqdto7.setContent("내용6");
        reqdto7.setTitle("제목6");
        postService.createPosts(reqdto7,"dudgh123");
        PostDto reqdto8 = new PostDto();
        reqdto8.setCategori(0L);
        reqdto8.setContent("내용7");
        reqdto8.setTitle("제목7");
        postService.createPosts(reqdto8,"dudgh123");
        PostDto reqdto9 = new PostDto();
        reqdto9.setCategori(1L);
        reqdto9.setContent("내용8");
        reqdto9.setTitle("제목8");
        postService.createPosts(reqdto9,"dudgh123");
        PostDto reqdto11 = new PostDto();
        reqdto11.setCategori(2L);
        reqdto11.setContent("내용9");
        reqdto11.setTitle("제목9");
        postService.createPosts(reqdto11,"dudgh123");
    }
    public void commentSet()
    {
        CommentDto com1 = new CommentDto();
        com1.setContent("내용1");
        com1.setUserNick("tmdwns123");
        com1.setPostId(1L);
        commentService.createComment(com1);
        CommentDto com2 = new CommentDto();
        com2.setContent("내용2");
        com2.setUserNick("tmdwns123");
        com2.setPostId(1L);
        commentService.createComment(com2);
        CommentDto com3 = new CommentDto();
        com3.setContent("내용3");
        com3.setUserNick("dudgh123");
        com3.setPostId(1L);
        commentService.createComment(com3);
        CommentDto com4 = new CommentDto();
        com4.setContent("내용4");
        com4.setUserNick("dudgh123");
        com4.setPostId(1L);
        commentService.createComment(com4);
        CommentDto com5 = new CommentDto();
        com5.setContent("내용5");
        com5.setUserNick("dudgh123");
        com5.setPostId(1L);
        commentService.createComment(com5);
        CommentDto com6 = new CommentDto();
        com6.setContent("내용6");
        com6.setUserNick("dudgh123");
        com6.setPostId(1L);
        commentService.createComment(com6);

    }
}

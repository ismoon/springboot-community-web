package com.ismoon.community;

import com.ismoon.community.domain.Board;
import com.ismoon.community.domain.User;
import com.ismoon.community.domain.enums.BoardType;
import com.ismoon.community.repository.BoardRepository;
import com.ismoon.community.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author ismoon on 2019-01-19
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle = "테스트";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init() {
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email(this.email)
                .createDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title(this.boardTestTitle)
                .subTitle("서브 타이틀")
                .content("콘텐츠")
                .boardType(BoardType.free)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .user(user)
                .build());

    }

    @Test
    public void createdTest() {
        User user = userRepository.findByEmail(this.email);

        assertThat(user.getName(), is("havi"));
        assertThat(user.getPassword(), is("test"));
        assertThat(user.getEmail(), is(this.email));

        Board board = boardRepository.findByUser(user);

        assertThat(board.getTitle(), is(this.boardTestTitle));
        assertThat(board.getSubTitle(), is("서브 타이틀"));
        assertThat(board.getContent(), is("콘텐츠"));
        assertThat(board.getBoardType(), is(BoardType.free));
    }
}

package ua.kh.baklanov.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.repository.DefaultUserDAOImpl;

import java.util.Objects;



@RunWith(MockitoJUnitRunner.class)
public class ContextTest {

    @Mock
    private DefaultFactory factory;

    @Mock
    private DefaultUserDAOImpl userDAO;

    @Before
    public void setUp() {
        Context.put(Attributes.DB_FACTORY, factory);
    }

    @Test
    public void putTest() {
        Context.put(Attributes.USER_DAO, userDAO);
        Assert.assertTrue("DefaultUserDAOImpl in context is not null",
                Objects.nonNull(Context.get(Attributes.USER_DAO)));
        Assert.assertTrue("user dao in context is instance of DefaultUserDAOImpl",
                Context.get(Attributes.USER_DAO) instanceof DefaultUserDAOImpl);
    }

    @Test
    public void getTest(){
        Assert.assertTrue("DefaultFactory in context is not null",
                Objects.nonNull(Context.get(Attributes.DB_FACTORY)));
    }

}

package ua.kh.baklanov.web.command.admin_panel;

import org.junit.Assert;
import org.junit.Test;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

public class AdminCommandContainerTest {

    private static final String NULL_COMMAND=null;
    private static final String NO_COMMAND="noCommand";
    private static final String USERS_COMMAND="users";

    @Test
    public void getCommandTest1(){
        AbstractCommand command = AdminCommandContainer.get(NULL_COMMAND);
        Assert.assertNotNull("command is not null",command);
        Assert.assertTrue("command is NoCommand", command instanceof NoCommand);
    }

    @Test
    public void getCommandTest2(){
        AbstractCommand command = AdminCommandContainer.get(NO_COMMAND);
        Assert.assertNotNull("command is not null",command);
        Assert.assertTrue("command is NoCommand", command instanceof NoCommand);
    }

    @Test
    public void getCommandTest3(){
        AbstractCommand command = AdminCommandContainer.get(USERS_COMMAND);
        Assert.assertNotNull("command is not null",command);
        Assert.assertTrue("command is UsersCommand", command instanceof UsersCommand);
    }
}

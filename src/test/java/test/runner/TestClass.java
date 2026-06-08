package test.runner;

import test.base.Base_Class;
import test.pageobjectmanager.PageObjectManager;
import test.pageobjectmodule.LogInPage;
import test.utility.FileReaderManager;

import java.io.IOException;

public class TestClass extends Base_Class {

    public static void main (String[] args) throws IOException, InterruptedException {
        PageObjectManager.getPageObjectManager().getFileReaderManager();
        launchBrowser(FileReaderManager.getDataProperty("browser"));
        PageObjectManager.getPageObjectManager().getFileReaderManager();
        launchUrl(FileReaderManager.getDataProperty("url"));
        PageObjectManager.getPageObjectManager();
        PageObjectManager.getLogInPage();
        LogInPage.validLogin();


    }


}

package test.pageobjectmanager;

import test.pageobjectmodule.LogInPage;
import test.utility.FileReaderManager;



public class PageObjectManager {

    private static LogInPage logInPage;
    FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;

    public static LogInPage getLogInPage() {
        if(logInPage == null){
            logInPage = new LogInPage();
        }
        return logInPage;
    }

    public FileReaderManager getFileReaderManager() {
        if(fileReaderManager== null){
            fileReaderManager= new FileReaderManager();
        }
        return fileReaderManager;
    }

    public static PageObjectManager getPageObjectManager() {
        if(pageObjectManager==null){
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }
}


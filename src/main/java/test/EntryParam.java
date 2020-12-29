package test;

import com.beust.jcommander.Parameter;

public class EntryParam {
    @Parameter(names = "-url", description = "kubesphere url", required = true)
    public String url;
    @Parameter(names = "-username", description = "username")
    public String username = "admin";
    @Parameter(names = "-password", description = "password", password = true)
    public String password = "P@88w0rd";
}

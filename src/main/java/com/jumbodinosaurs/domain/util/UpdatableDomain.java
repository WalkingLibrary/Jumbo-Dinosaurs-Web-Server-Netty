package com.jumbodinosaurs.domain.util;

public class UpdatableDomain extends Domain
{
    private String username;
    private String password;
    
    public UpdatableDomain(String domain, String username, String password)
    {
        super(domain);
        this.username = username;
        this.password = password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
package com.albertsons.api.framework.support.database;

import java.util.Date;
import java.util.List;
import java.util.Map;
import static java.lang.String.format;

public class DBConfiguration {

  private Date released;
  private String version;
  private DBConnection connection;
  private List< String > protocols;
  private Map< String, String > users;

  public Date getReleased() {
    return released;
  }

  public String getVersion() {
    return version;
  }

  public void setReleased(Date released) {
    this.released = released;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public DBConnection getConnection() {
    return connection;
  }

  public void setConnection(DBConnection connection) {
    this.connection = connection;
  }

  public List< String > getProtocols() {
    return protocols;
  }

  public void setProtocols(List< String > protocols) {
    this.protocols = protocols;
  }

  public Map< String, String > getUsers() {
    return users;
  }

  public void setUsers(Map< String, String > users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append( format( "Version: %s\n", version ) )
        .append( format( "Released: %s\n", released ) )
        .append( format( "Connecting to database: %s\n", connection ) )
        .append( format( "Supported protocols: %s\n", protocols ) )
        .append( format( "Users: %s\n", users ) )
        .toString();
  }
  }
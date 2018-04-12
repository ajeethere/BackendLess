
package com.example.ajeet.backendless;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class profileTable
{
  private String name;
  private String mobileNo;
  private String imageUrl;
  private String objectId;
  private java.util.Date created;
  private String ownerId;
  private String add;
  private java.util.Date updated;
  private String email;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getMobileNo()
  {
    return mobileNo;
  }

  public void setMobileNo( String mobileNo )
  {
    this.mobileNo = mobileNo;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl( String imageUrl )
  {
    this.imageUrl = imageUrl;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getAdd()
  {
    return add;
  }

  public void setAdd( String add )
  {
    this.add = add;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

                                                    
  public profileTable save()
  {
    return Backendless.Data.of( profileTable.class ).save( this );
  }

  public void saveAsync( AsyncCallback<profileTable> callback )
  {
    Backendless.Data.of( profileTable.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( profileTable.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( profileTable.class ).remove( this, callback );
  }

  public static profileTable findById( String id )
  {
    return Backendless.Data.of( profileTable.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<profileTable> callback )
  {
    Backendless.Data.of( profileTable.class ).findById( id, callback );
  }

  public static profileTable findFirst()
  {
    return Backendless.Data.of( profileTable.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<profileTable> callback )
  {
    Backendless.Data.of( profileTable.class ).findFirst( callback );
  }

  public static profileTable findLast()
  {
    return Backendless.Data.of( profileTable.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<profileTable> callback )
  {
    Backendless.Data.of( profileTable.class ).findLast( callback );
  }

  public static List<profileTable> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( profileTable.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<profileTable>> callback )
  {
    Backendless.Data.of( profileTable.class ).find( queryBuilder, callback );
  }
}
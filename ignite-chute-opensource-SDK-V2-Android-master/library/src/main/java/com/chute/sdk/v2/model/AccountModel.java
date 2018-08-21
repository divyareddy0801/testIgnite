// Copyright (c) 2011, Chute Corporation. All rights reserved.
// 
//  Redistribution and use in source and binary forms, with or without modification, 
//  are permitted provided that the following conditions are met:
// 
//     * Redistributions of source code must retain the above copyright notice, this 
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
// 
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
//
package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * The {@link AccountModel} class represents the concept of an account.
 * <p>
 * Each account contains type, name, shortcut, user details, access key, secret
 * and time of creation and update.
 * 
 */
public class AccountModel implements Parcelable {

  @SuppressWarnings("unused")
  private static final String TAG = AccountModel.class.getSimpleName();

  /**
   * The unique identifier of the account.
   */
  @JsonProperty("id")
  private String id;
  /**
   * Type of the account. It can be: facebook, picasa, flickr, instagram,
   * googledrive, skydrive, google or dropbox.
   */
  @JsonProperty("type")
  private String type;
  /**
   * Account name.
   */
  @JsonProperty("name")
  private String name;
  /**
   * Account user unique identifier.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * Time of creation.
   */
  @JsonProperty("created_at")
  private String createdAt;
  /**
   * Time of update.
   */
  @JsonProperty("updated_at")
  private String updatedAt;

  /**
   * Account shortcut.
   */
  @JsonProperty("shortcut")
  private String shortcut;

  /**
   * The username of the user currently authenticated.
   */
  @JsonProperty("username")
  private String username;

  /**
   * User avatar
   */
  @JsonProperty("avatar")
  private String avatar;

  /**
   * Account access key
   */
  @JsonProperty("access_key")
  private String accessKey;

  /**
   * Account access secret
   */
  @JsonProperty("access_secret")
  private String accessSecret;

  /**
   * E-mail of the user
   */
  @JsonProperty("email")
  private String email;

  /**
   * Default non-args constructor.
   */
  public AccountModel() {
  }

  /**
   * Getter and setter methods.
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getShortcut() {
    return shortcut;
  }

  public void setShortcut(String shortcut) {
    this.shortcut = shortcut;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getAccessSecret() {
    return accessSecret;
  }

  public void setAccessSecret(String accessSecret) {
    this.accessSecret = accessSecret;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AccountModel(Parcel in) {
    id = in.readString();
    type = in.readString();
    name = in.readString();
    uid = in.readString();
    createdAt = in.readString();
    updatedAt = in.readString();
    shortcut = in.readString();
    username = in.readString();
    avatar = in.readString();
    accessKey = in.readString();
    accessSecret = in.readString();
    email = in.readString();
  }

  /*
   * (non-Javadoc)
   * @see android.os.Parcelable#describeContents()
   */
  @Override
  public int describeContents() {
    return 0;
  }

  /*
   * (non-Javadoc)
   * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
   */
  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(type);
    dest.writeString(name);
    dest.writeString(uid);
    dest.writeString(createdAt);
    dest.writeString(updatedAt);
    dest.writeString(shortcut);
    dest.writeString(username);
    dest.writeString(avatar);
    dest.writeString(accessKey);
    dest.writeString(accessSecret);
    dest.writeString(email);

  }

  public static final Creator<AccountModel> CREATOR = new Creator<AccountModel>() {

    @Override
    public AccountModel createFromParcel(Parcel in) {
      return new AccountModel(in);
    }

    @Override
    public AccountModel[] newArray(int size) {
      return new AccountModel[size];
    }
  };

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountModel [id=");
    builder.append(id);
    builder.append(", type=");
    builder.append(type);
    builder.append(", name=");
    builder.append(name);
    builder.append(", uid=");
    builder.append(uid);
    builder.append(", createdAt=");
    builder.append(createdAt);
    builder.append(", updatedAt=");
    builder.append(updatedAt);
    builder.append(", shortcut=");
    builder.append(shortcut);
    builder.append(", username=");
    builder.append(username);
    builder.append(", avatar=");
    builder.append(avatar);
    builder.append(", accessKey=");
    builder.append(accessKey);
    builder.append(", accessSecret=");
    builder.append(accessSecret);
    builder.append(", email=");
    builder.append(email);
    builder.append("]");
    return builder.toString();
  }

  /**
   * Serializes {@link AccountModel} as a String.
   * 
   * @return JSon string that contains all {@link AccountModel} fields and their
   *         appropriate values.
   */
  public String toJSON() {
    try {
      return JsonUtil.getMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
      Log.e(TAG, e.getMessage(), e);
    }
    return "";
  }

  /**
   * Deserializes JSon content into {@link AccountModel}.
   * 
   * @param json
   *          The JSon that needs to be deserialized into {@link AccountModel}.
   * @return {@link AccountModel} containing values from the given JSon.
   */
  public static AccountModel fromJSON(String json) {
    try {
      return JsonUtil.getMapper().readValue(json, AccountModel.class);
    } catch (Exception e) {
      Log.e(TAG, e.getMessage(), e);
    }
    return null;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accessKey == null) ? 0 : accessKey.hashCode());
    result = prime * result + ((accessSecret == null) ? 0 : accessSecret.hashCode());
    result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
    result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((shortcut == null) ? 0 : shortcut.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
    result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AccountModel other = (AccountModel) obj;
    if (accessKey == null) {
      if (other.accessKey != null)
        return false;
    } else if (!accessKey.equals(other.accessKey))
      return false;
    if (accessSecret == null) {
      if (other.accessSecret != null)
        return false;
    } else if (!accessSecret.equals(other.accessSecret))
      return false;
    if (avatar == null) {
      if (other.avatar != null)
        return false;
    } else if (!avatar.equals(other.avatar))
      return false;
    if (createdAt == null) {
      if (other.createdAt != null)
        return false;
    } else if (!createdAt.equals(other.createdAt))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (shortcut == null) {
      if (other.shortcut != null)
        return false;
    } else if (!shortcut.equals(other.shortcut))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
      return false;
    if (updatedAt == null) {
      if (other.updatedAt != null)
        return false;
    } else if (!updatedAt.equals(other.updatedAt))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

}

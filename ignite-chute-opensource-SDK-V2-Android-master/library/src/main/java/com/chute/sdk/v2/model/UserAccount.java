package com.chute.sdk.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccount {

  @JsonProperty("id")
  String id;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("updated_at")
  private String updatedAt;

  @JsonProperty("shortcut")
  private String shortcut;

  @JsonProperty("uid")
  private String uid;

  @JsonProperty("type")
  private String type;

  @JsonProperty("name")
  private String name;

  @JsonProperty("username")
  private String username;

  @JsonProperty("avatar")
  private String avatar;

  @JsonProperty("access_key")
  private String accessKey;
  @JsonProperty("access_secret")
  private String accessSecret;

  @JsonProperty("email")
  private String email;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
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

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserAccount that = (UserAccount) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
    if (shortcut != null ? !shortcut.equals(that.shortcut) : that.shortcut != null) return false;
    if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
    if (type != null ? !type.equals(that.type) : that.type != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
    if (accessKey != null ? !accessKey.equals(that.accessKey) : that.accessKey != null) return false;
    if (accessSecret != null ? !accessSecret.equals(that.accessSecret) : that.accessSecret != null) return false;
    return !(email != null ? !email.equals(that.email) : that.email != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (shortcut != null ? shortcut.hashCode() : 0);
    result = 31 * result + (uid != null ? uid.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
    result = 31 * result + (accessKey != null ? accessKey.hashCode() : 0);
    result = 31 * result + (accessSecret != null ? accessSecret.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}

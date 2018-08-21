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
package com.chute.sdk.v2.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.chute.sdk.v2.model.AccountModel;

public class PreferenceUtil {

  public static final String TAG = PreferenceUtil.class.getSimpleName();
  private final Context context;

  private static final String PREF_FILE_NAME = "chute_preferences";
  
  private PreferenceUtil(Context context) {
    this.context = context;
  }

  static PreferenceUtil instance;

  public static PreferenceUtil get() {
    return instance;
  }

  public static boolean isInitialized() {
    return instance != null;
  }

  public static void init(Context context) {
    if (instance == null) {
      instance = new PreferenceUtil(context.getApplicationContext());
    }
  }

  public SharedPreferences getPreferences() {
    return context.getSharedPreferences(PREF_FILE_NAME,
        Context.MODE_PRIVATE);
  }
  public void clearAll(){
    getPreferences().edit().clear().commit();
  }

  private final <T> void setPreference(final String key, final T value) {
    SharedPreferences.Editor edit = getPreferences().edit();
    if (value.getClass().equals(String.class)) {
      edit.putString(key, (String) value);
    } else if (value.getClass().equals(Boolean.class)) {
      edit.putBoolean(key, (Boolean) value);
    } else if (value.getClass().equals(Integer.class)) {
      edit.putInt(key, (Integer) value);
    } else if (value.getClass().equals(Long.class)) {
      edit.putLong(key, (Long) value);
    } else if (value.getClass().equals(Float.class)) {
      edit.putFloat(key, (Float) value);
    } else {
      throw new UnsupportedOperationException(
          "Need to add a primitive type to shared prefs");
    }
    edit.commit();
  }

  public void saveAccount(AccountModel model) {
    setPreference(model.getType(), model.toJSON());
  }

  public AccountModel getAccount(String type) {
    String accountString = getPreferences().getString(type, null);
    return AccountModel.fromJSON(accountString);
  }

  public boolean hasAccount(String accountType) {
    return getPreferences().contains(accountType);
  }

}

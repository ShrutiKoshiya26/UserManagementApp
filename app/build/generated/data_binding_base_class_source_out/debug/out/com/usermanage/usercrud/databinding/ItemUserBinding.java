// Generated by data binding compiler. Do not edit!
package com.usermanage.usercrud.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.usermanage.usercrud.R;
import com.usermanage.usercrud.data.model.User;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemUserBinding extends ViewDataBinding {
  @NonNull
  public final TextView ageTextView;

  @NonNull
  public final ImageView deleteButton;

  @NonNull
  public final ImageView editButton;

  @NonNull
  public final TextView emailTextView;

  @NonNull
  public final TextView nameTextView;

  @Bindable
  protected User mUser;

  protected ItemUserBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView ageTextView, ImageView deleteButton, ImageView editButton, TextView emailTextView,
      TextView nameTextView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ageTextView = ageTextView;
    this.deleteButton = deleteButton;
    this.editButton = editButton;
    this.emailTextView = emailTextView;
    this.nameTextView = nameTextView;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_user, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemUserBinding>inflateInternal(inflater, R.layout.item_user, root, attachToRoot, component);
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_user, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemUserBinding>inflateInternal(inflater, R.layout.item_user, null, false, component);
  }

  public static ItemUserBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemUserBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemUserBinding)bind(component, view, R.layout.item_user);
  }
}
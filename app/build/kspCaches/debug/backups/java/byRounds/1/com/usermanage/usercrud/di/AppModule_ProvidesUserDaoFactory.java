package com.usermanage.usercrud.di;

import com.usermanage.usercrud.data.local.UserDao;
import com.usermanage.usercrud.data.local.UserDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AppModule_ProvidesUserDaoFactory implements Factory<UserDao> {
  private final AppModule module;

  private final Provider<UserDatabase> userDatabaseProvider;

  public AppModule_ProvidesUserDaoFactory(AppModule module,
      Provider<UserDatabase> userDatabaseProvider) {
    this.module = module;
    this.userDatabaseProvider = userDatabaseProvider;
  }

  @Override
  public UserDao get() {
    return providesUserDao(module, userDatabaseProvider.get());
  }

  public static AppModule_ProvidesUserDaoFactory create(AppModule module,
      Provider<UserDatabase> userDatabaseProvider) {
    return new AppModule_ProvidesUserDaoFactory(module, userDatabaseProvider);
  }

  public static UserDao providesUserDao(AppModule instance, UserDatabase userDatabase) {
    return Preconditions.checkNotNullFromProvides(instance.providesUserDao(userDatabase));
  }
}

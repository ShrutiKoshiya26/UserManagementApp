package com.usermanage.usercrud.di;

import com.usermanage.usercrud.data.local.UserDao;
import com.usermanage.usercrud.data.repository.UserRepository;
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
public final class AppModule_ProvidesUserRepositoryFactory implements Factory<UserRepository> {
  private final AppModule module;

  private final Provider<UserDao> userDaoProvider;

  public AppModule_ProvidesUserRepositoryFactory(AppModule module,
      Provider<UserDao> userDaoProvider) {
    this.module = module;
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public UserRepository get() {
    return providesUserRepository(module, userDaoProvider.get());
  }

  public static AppModule_ProvidesUserRepositoryFactory create(AppModule module,
      Provider<UserDao> userDaoProvider) {
    return new AppModule_ProvidesUserRepositoryFactory(module, userDaoProvider);
  }

  public static UserRepository providesUserRepository(AppModule instance, UserDao userDao) {
    return Preconditions.checkNotNullFromProvides(instance.providesUserRepository(userDao));
  }
}

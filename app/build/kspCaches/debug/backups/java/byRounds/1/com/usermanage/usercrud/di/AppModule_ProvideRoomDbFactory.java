package com.usermanage.usercrud.di;

import android.content.Context;
import com.usermanage.usercrud.data.local.UserDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideRoomDbFactory implements Factory<UserDatabase> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideRoomDbFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public UserDatabase get() {
    return provideRoomDb(module, contextProvider.get());
  }

  public static AppModule_ProvideRoomDbFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideRoomDbFactory(module, contextProvider);
  }

  public static UserDatabase provideRoomDb(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideRoomDb(context));
  }
}

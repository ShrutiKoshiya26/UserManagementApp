package com.usermanage.usercrud.di;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideApplicationFactory implements Factory<Application> {
  private final AppModule module;

  public AppModule_ProvideApplicationFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Application get() {
    return provideApplication(module);
  }

  public static AppModule_ProvideApplicationFactory create(AppModule module) {
    return new AppModule_ProvideApplicationFactory(module);
  }

  public static Application provideApplication(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideApplication());
  }
}

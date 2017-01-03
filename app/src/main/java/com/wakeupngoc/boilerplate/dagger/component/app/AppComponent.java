package com.wakeupngoc.boilerplate.dagger.component.app;

import com.wakeupngoc.boilerplate.BoilerplateApp;
import com.wakeupngoc.boilerplate.dagger.module.AppModule;
import com.wakeupngoc.boilerplate.dagger.module.RemoteModule;
import com.wakeupngoc.boilerplate.dagger.scope.AppScope;
import com.wakeupngoc.boilerplate.presentation.images.list.ImagesListComponent;
import com.wakeupngoc.boilerplate.presentation.images.list.ImagesListModule;

import dagger.Component;

/**
 * Created by ngoctranfire on 12/18/16.
 */
@AppScope
@Component(modules = {AppModule.class, RemoteModule.class})
public interface AppComponent {
    BoilerplateApp inject(BoilerplateApp boilerplateApp);
    ImagesListComponent plus(ImagesListModule imagesListModule);

    @Component.Builder
    interface Builder {
        Builder appModule(AppModule module);
        Builder remoteModule(RemoteModule remoteModule);
        AppComponent build();
    }
}

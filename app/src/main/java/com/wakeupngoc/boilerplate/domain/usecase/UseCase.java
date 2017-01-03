package com.wakeupngoc.boilerplate.domain.usecase;
/**
 * * Created by ngoctranfire on 12/18/16.
 */

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {

    private final Scheduler backgroundScheduler;

    protected UseCase(Scheduler backgroundScheduler) {
        this.backgroundScheduler = backgroundScheduler;
    }

    public Observable<P> run(Q requestValues) {
        return executeUseCase(requestValues)
            .subscribeOn(backgroundScheduler)
            .observeOn(AndroidSchedulers.mainThread());
    }

    protected abstract Observable<P> executeUseCase(Q requestValues);

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }
}
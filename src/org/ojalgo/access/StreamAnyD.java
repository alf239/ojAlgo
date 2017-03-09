package org.ojalgo.access;

import org.ojalgo.function.BinaryFunction;
import org.ojalgo.function.ParameterFunction;
import org.ojalgo.function.UnaryFunction;

public interface StreamAnyD<N extends Number, A extends AccessAnyD<N>, R extends MutateAnyD.Receiver<N>, P extends StreamAnyD<N, A, R, P>>
        extends AccessAnyD.Collectable<N, R> {

    default P operateOnAll(final BinaryFunction<N> operator, double right) {
        return this.operateOnAll(operator.second(right));
    }

    default P operateOnAll(final BinaryFunction<N> operator, N right) {
        return this.operateOnAll(operator.second(right));
    }

    default P operateOnAll(double left, final BinaryFunction<N> operator) {
        return this.operateOnAll(operator.first(left));
    }

    default P operateOnAll(N left, final BinaryFunction<N> operator) {
        return this.operateOnAll(operator.first(left));
    }

    default P operateOnAll(final ParameterFunction<N> operator, int parameter) {
        return this.operateOnAll(operator.parameter(parameter));
    }

    P operateOnAll(final UnaryFunction<N> operator);

    P operateOnMatching(final A left, final BinaryFunction<N> operator);

    P operateOnMatching(final BinaryFunction<N> operator, final A right);

}
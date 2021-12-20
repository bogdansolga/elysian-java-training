package com.elysian.java.training.d01.s3;

import java.io.Serializable;
import java.util.List;

// Input and Output are generic types
public interface Converter<Input extends Serializable, Output> {

    public Output convertToOutput(Input input);

    @SuppressWarnings("unchecked")
    public default <Type, Type1> Type processProducts(List<Type> products,
                                                      List<Type1> theOtherList) {
        return (Type) new Object();
    }
}

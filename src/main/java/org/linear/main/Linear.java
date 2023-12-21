package org.linear.main;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import java.nio.Buffer;

public non-sealed interface Linear<E extends Number, V extends Linear<E, V>>
        extends Array<E> {
   @Final
   Buffer get(Buffer pointer);

   @Final
   void set(int index, E value);

   @PropertiesMethod
   boolean isScalar();

   boolean equals(V value);

   @Final
   boolean isNaN();
}

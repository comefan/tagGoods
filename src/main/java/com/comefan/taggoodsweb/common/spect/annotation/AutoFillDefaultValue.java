package com.comefan.taggoodsweb.common.spect.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoFillDefaultValue {
}

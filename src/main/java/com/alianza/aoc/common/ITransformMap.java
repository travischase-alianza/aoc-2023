package com.alianza.aoc.common;

import java.util.Map;

public interface ITransformMap extends ITransform< Map<String, Object> > {
    @Override public Map<String, Object> transform(int id, String in);
}
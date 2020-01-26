package cn.brickie.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public class MapperUtil {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper copy() {
        ModelMapper mapper = new ModelMapper();
        config(mapper);
        return mapper;
    }

    public static void config(ModelMapper modelMapper) {
        modelMapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setCollectionsMergeEnabled(false)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMethodAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    static {
        config(modelMapper);
    }

    public static <E, V> V map(E record, Class<V> object) {
        return modelMapper.map(record, object);
    }

    public static <E, V> V map(E sourceObj, V destinationObj) {
        modelMapper.map(sourceObj, destinationObj);
        return destinationObj;
    }

    public static <E, V> V mapSolveNullObjMappingEmptyObj(E sourceObj, V destinationObj) {
        Object destObjMappingByClass = modelMapper.map(sourceObj, destinationObj.getClass());
        modelMapper.map(destObjMappingByClass, destinationObj);
        return destinationObj;
    }

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}

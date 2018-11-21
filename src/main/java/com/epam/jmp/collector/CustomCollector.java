package com.epam.jmp.collector;

import com.epam.jmp.entity.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector {
    @Override
    public Supplier<HashMap<String, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<HashMap<String, Integer>, List<Person>> accumulator() {
        return ((stringIntegerHashMap, personList) -> personList
                .forEach(person -> stringIntegerHashMap.put(person.getName(), person.getAge())));
    }

    @Override
    public BinaryOperator<HashMap<String, Integer>> combiner() {
        return ((stringIntegerHashMap, stringIntegerHashMap2) -> {stringIntegerHashMap
                .putAll(stringIntegerHashMap2); return stringIntegerHashMap; });

    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

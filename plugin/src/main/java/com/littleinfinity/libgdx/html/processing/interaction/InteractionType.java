package com.littleinfinity.libgdx.html.processing.interaction;

import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

public enum InteractionType {
    ALL, CLICK;

    public static List<InteractionType> parseStringNames(String[] names) {
        List<String> nameList = newArrayList(names);
        List<InteractionType> interactionList = newArrayList();
        filter(newArrayList(InteractionType.values()), (interaction) -> nameList.contains(interaction.toString().toLowerCase()));
        return interactionList;
    }
}

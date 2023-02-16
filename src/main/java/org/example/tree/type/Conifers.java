package org.example.tree.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tree.Tree;
import org.example.tree.enums.ConifersType;

@Getter
@Setter
@NoArgsConstructor
public class Conifers extends Tree {
    private ConifersType type;
    private int countOfConifers;
}

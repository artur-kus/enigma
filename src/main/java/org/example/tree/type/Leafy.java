package org.example.tree.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tree.Tree;
import org.example.tree.enums.LeafyType;

@Getter
@Setter
@NoArgsConstructor
public class Leafy extends Tree {
    private LeafyType type;
    private int countOfLeafs;
}

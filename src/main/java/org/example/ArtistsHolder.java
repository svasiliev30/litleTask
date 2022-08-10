package org.example;

import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistsHolder {

   private Set<Artist> artists = new HashSet<>();
}

/* LanguageTool, a natural language style checker 
 * Copyright (C) 2005 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.nl;

import org.languagetool.rules.AbstractWordCoherencyRule;
import org.languagetool.rules.Example;
import org.languagetool.rules.WordCoherencyDataLoader;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Dutch version of {@link AbstractWordCoherencyRule}.
 */
public class WordCoherencyRule extends AbstractWordCoherencyRule {

  private static final Map<String, String> wordMap = new WordCoherencyDataLoader().loadWords("/nl/coherency.txt");

  public WordCoherencyRule(ResourceBundle messages) throws IOException {
    super(messages);
    //addExamplePair(Example.wrong("Die Delfine gehören zu den Zahnwalen. <marker>Delphine</marker> sind in allen Meeren verbreitet."),
    //               Example.fixed("Die Delfine gehören zu den Zahnwalen. <marker>Delfine</marker> sind in allen Meeren verbreitet."));
  }

  @Override
  protected Map<String, String> getWordMap() {
    return wordMap;
  }

  @Override
  protected String getMessage(String word1, String word2) {
    return "Gebruik liever geen verschillende spellingen ('" + word1 + "' en '" + word2 + "') door elkaar in een tekst.";
  }

  @Override
  public String getId() {
    return "NL_WORD_COHERENCY";
  }

  @Override
  public String getDescription() {
    return "Consistente spelling van woorden met meerdere correcte vormen.";
  }

}

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.hadoop.zebra.mapred;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.zebra.tfile.TFile;

/**
 * A wrapper class for SortInfo.
 */
public class ZebraSortInfo {
  private String sortColumnsStr = null;
  private String comparatorStr = null;
  
  private ZebraSortInfo(String sortColumns, Class<? extends RawComparator<Object>> comparatorClass) {
    if (comparatorClass != null)
      comparatorStr = TFile.COMPARATOR_JCLASS+comparatorClass.getName();
    sortColumnsStr = sortColumns;
  }
  
  public static ZebraSortInfo createZebraSortInfo(String sortColumns, Class<? extends RawComparator<Object>> comparatorClass) {
    return new ZebraSortInfo(sortColumns, comparatorClass);
  }
  
  public String getSortColumns() {
    return sortColumnsStr;
  }

  public String getComparator() {
    return comparatorStr;
  }    
}

package com.example.project.util;

import java.util.Map;

public class csvUtil {
    public static<T> String convertHashMapToCsv(Map<String, T> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }

        StringBuilder csvData = new StringBuilder();

        // Append CSV header if needed
        // csvData.append("Key,Value\n");

        for (Map.Entry<String, T> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());

            // If you have complex data or data containing special characters,
            // make sure to handle proper escaping here.

            csvData.append(key).append(", ").append(value).append("\n");
        }

        return csvData.toString();
    }
}

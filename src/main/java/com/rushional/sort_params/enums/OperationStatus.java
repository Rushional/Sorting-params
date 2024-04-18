package com.rushional.sort_params.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OperationStatus {
    SUCCESS("success");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}

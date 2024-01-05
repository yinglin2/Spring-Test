package com.spring.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    /**
     * supports方法用来表示此校验用在哪个类型上
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * validate是设置校验逻辑的地点，其中ValidationUtils，是Spring封装的校验工具类，帮助快速实现校验。
     * 校验规则
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        // name不能为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "name is null");
        // age 不能小于0，不能大于200
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "age.value.less.zero", "age < 0");
        } else if (p.getAge() > 200) {
            errors.rejectValue("age", "age.value.exceed", "age > 200");
        }

    }
}

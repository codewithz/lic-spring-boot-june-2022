# lic-spring-boot-june-2022

<img width="804" alt="jpa-1" src="https://user-images.githubusercontent.com/71726246/174946290-4a4fbb15-c6f0-4207-b133-069ee9e9931a.PNG">


<img width="899" alt="jpa-2" src="https://user-images.githubusercontent.com/71726246/174946321-26ab9166-43ac-4f00-aa19-a5bee4d1075c.PNG">

**CascadeType.PERSIST**: When persisting an entity, also persist the entities held in its fields. We suggest a liberal application of this cascade rule, because if the EntityManager finds a field that references a new entity during the flush, and the field does not use CascadeType.PERSIST, it is an error.

**CascadeType.REMOVE**: When deleting an entity, it also deletes the entities held in this field.

**CascadeType.REFRESH:** When refreshing an entity, also refresh the entities held in this field.

**CascadeType.MERGE:** When merging entity state, also merge the entities held in this field.

INSERT INTO `users`(`password`, `username`, `created_at`) VALUES ('{noop}admin1','admin1', '2023-07-06 12:07:00')
INSERT INTO `users`(`password`, `username`, `created_at`) VALUES ('{noop}admin2','admin2', '2023-07-06 12:07:00')
INSERT INTO `users`(`password`, `username`, `created_at`) VALUES ('{noop}admin3','admin3', '2023-07-06 12:07:00')
INSERT INTO `roles`(`name`) VALUES ('ADMIN')
INSERT INTO `users_roles`(`user_id`, `roles_id`) VALUES (1, 1)
INSERT INTO `users_roles`(`user_id`, `roles_id`) VALUES (2, 1)
INSERT INTO `users_roles`(`user_id`, `roles_id`) VALUES (3, 1)

INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 1','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '1')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 2','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '1')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 3','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '1')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 4','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '2')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 5','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '2')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 6','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '3')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 7','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '3')
INSERT INTO `photos`(`title`, `description`, `created_at`, `visible`, `user_id`) VALUES ('foto 8','Foto generata da intelligenza artificiale', '2023-07-06 12:07:00', true, '3')

INSERT INTO `categories`(`name`, `created_at`) VALUES ('Natura', '2023-07-06 12:07:00')
INSERT INTO `categories`(`name`, `created_at`) VALUES ('Mare', '2023-07-06 12:07:00')
INSERT INTO `categories`(`name`, `created_at`) VALUES ('Montagna', '2023-07-06 12:07:00')
INSERT INTO `categories`(`name`, `created_at`) VALUES ('Città', '2023-07-06 12:07:00')
INSERT INTO `categories`(`name`, `created_at`) VALUES ('Monumenti', '2023-07-06 12:07:00')

INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','1')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('3','1')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','2')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('2','2')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','3')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('2','3')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('4','3')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('4','4')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('5','4')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','5')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('3','5')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('4','5')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','6')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('4','6')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('2','7')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('5','7')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('4','7')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('1','8')
INSERT INTO `category_photo`(`category_id`, `photo_id`) VALUES ('2','8')







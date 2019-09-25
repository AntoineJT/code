sudo apt install php-cli php-mbstring php-xml

php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');" && sudo php composer-setup.php --filename=composer --install-dir=/usr/local/bin || exit 1

composer create-project --prefer-dist laravel/laravel laravel
cd laravel
composer update
composer dump-autoload
composer install --no-scripts

echo "php artisan serve" >> laravel-run.sh
sh laravel-run.sh


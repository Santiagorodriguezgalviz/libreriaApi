# Generated by Django 5.0.6 on 2024-06-29 06:39

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('libreria', '0006_alter_multa_estado_multa_alter_prestamo_estado_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='multa',
            name='estado_multa',
            field=models.IntegerField(choices=[(1, 'Pendiente'), (2, 'Pagado')]),
        ),
        migrations.AlterField(
            model_name='prestamo',
            name='Estado',
            field=models.IntegerField(choices=[(1, 'Préstamo'), (2, 'Entregado'), (3, 'Cancelado')]),
        ),
        migrations.AlterField(
            model_name='usuario',
            name='tipoUsuario',
            field=models.IntegerField(choices=[(1, 'lector'), (2, 'bibliotecario'), (3, 'administrador')]),
        ),
    ]

# Generated by Django 5.0.6 on 2024-06-13 22:01

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('libreria', '0002_usuario_alter_libro_genero'),
    ]

    operations = [
        migrations.CreateModel(
            name='prestamo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('fecha_prestamo', models.DateField()),
                ('fecha_devolucion', models.DateField()),
                ('Estado', models.IntegerField(choices=[(1, 'Préstamo'), (2, 'Entregado'), (3, 'Cancelado')])),
                ('libro', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='prestamo', to='libreria.libro')),
                ('usuario', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, related_name='prestamo', to='libreria.usuario')),
            ],
        ),
        migrations.CreateModel(
            name='multa',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('fecha_multa', models.DateField()),
                ('valor_multa', models.IntegerField()),
                ('estado_multa', models.IntegerField(choices=[(1, 'Pendiente'), (2, 'Pagado')], default=1)),
                ('usuario_multado', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='multa', to='libreria.usuario')),
                ('prestamo', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='multa', to='libreria.prestamo')),
            ],
        ),
    ]
